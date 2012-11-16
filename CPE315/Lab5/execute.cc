/* Lab 5: MIPS simulator
 * Written by Tyler Holland and Ryan Coonan
 */
#include "mipsim.hpp"

Stats stats;
Caches caches(0);
bool branchlast = false;
unsigned int branchpc = 0;
bool loadlast = false;
unsigned int loadregister = 0;


unsigned int signExtend16to32ui(short i) {
  return static_cast<unsigned int>(static_cast<int>(i));
}

unsigned int signExtend8to32ui(char i) {
   return static_cast<unsigned int>(static_cast<int>(i));
}
void execute() {
  Data32 instr = imem[pc];
  GenericType rg(instr);
  RType rt(instr);
  IType ri(instr);
  JType rj(instr);
  unsigned int pctarget = pc + 4;
  unsigned int addr;
  stats.instrs++;
  pc = pctarget;
  
  Data32 temp = 0;
  
  if(branchlast == true)
  {
     pc = branchpc;
     pctarget = branchpc;
     branchlast = false;
  }
  switch(rg.op) {
  case OP_SPECIAL:
    switch(rg.func) {
    case SP_ADDU:
      rf.write(rt.rd, rf[rt.rs] + rf[rt.rt]);
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
    case SP_SLL:
      rf.write(rt.rd, rf[rt.rt] << rt.sa);
      if(loadlast == true)
      {
         if(rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
    /*Added code*/
   case SP_SLT:
      if((static_cast<int>(rf[rt.rs])) < (static_cast<int>(rf[rt.rt])))
      {
      rf.write(rt.rd, 1);
      }
      else
      {
      rf.write(rt.rd, 0);
      }
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
   case SP_JR:
      pc.write(rf[rt.rs]);
      if(loadlast == true)
      {
         if(rt.rs == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
   case SP_SRL:
      rf.write(rt.rd, rf[rt.rt] >> rt.sa);
      if(loadlast == true)
      {
         if(rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
    default:
      cout << "Unsupported instruction: ";
      instr.printI(instr);
      exit(1);
      break;
    }
    break;
  case OP_ADDIU:
    rf.write(ri.rt, rf[ri.rs] + signExtend16to32ui(ri.imm));
    if(loadlast == true)
      {
         if(rt.rs == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
    break;
  case OP_SW:
    addr = rf[ri.rs] + signExtend16to32ui(ri.imm);
    caches.access(addr);
    dmem.write(addr, rf[ri.rt]);
    if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
    break;
  case OP_LW:
    addr = rf[ri.rs] + signExtend16to32ui(ri.imm);
    caches.access(addr);
    rf.write(ri.rt, dmem[addr]);
    loadlast = true;
    loadregister = ri.rt;
    break;
  /*Added code*/
   case OP_SLTI:
      if((static_cast<int>(rf[ri.rs]) < (static_cast<int>(signExtend16to32ui(ri.imm)))))
      {
         rf.write(ri.rt, 1);
      }
      else
      {
         rf.write(ri.rt, 0);
      }
      break;
   case OP_SLTIU:
      if((static_cast<int>(rf[ri.rs]) < (signExtend16to32ui(ri.imm))))
      {
         rf.write(ri.rt, 1);
      }
      else
      {
         rf.write(ri.rt, 0);
      }
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
   case OP_BNE:
      branchpc = (pctarget + static_cast<int>((signExtend16to32ui(ri.imm))<<2));
      if(rf[ri.rs] != rf[ri.rt])
      {
         //pc.write((pctarget) + ((signExtend16to32ui(ri.imm))<<2));
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesTaken++;
         }
         else
         {
            stats.numForwardBranchesTaken++;
         }
         branchlast = true;
      }
      else
      {
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesNotTaken++;
         }
         else
         {
            stats.numForwardBranchesNotTaken++;
         }
      }
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      if(imem[pctarget].data_uint() == 0)
      {
         stats.hasUselessBranchDelaySlot++;
      }
      else
      {
         stats.hasUsefulBranchDelaySlot++;
      }
      break;
   case OP_BEQ:
      branchpc = (pctarget + static_cast<int>((signExtend16to32ui(ri.imm))<<2));
      if(rf[ri.rs] == rf[ri.rt])
      {
         //pc.write((pctarget) + ((signExtend16to32ui(ri.imm))<<2));
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesTaken++;
         }
         else
         {
            stats.numForwardBranchesTaken++;
         }
         branchlast = true;
      }
      else
      {
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesNotTaken++;
         }
         else
         {
            stats.numForwardBranchesNotTaken++;
         }
      }
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      if(imem[pctarget].data_uint() == 0)
      {
         stats.hasUselessBranchDelaySlot++;
      }
      else
      {
         stats.hasUsefulBranchDelaySlot++;
      }
      break;
   case OP_BLEZ:
      branchpc = (pctarget + static_cast<int>((signExtend16to32ui(ri.imm))<<2));
      if(static_cast<int>(rf[ri.rs]) <= 0)
      {
         //pc.write((pctarget) + ((signExtend16to32ui(ri.imm))<<2));
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesTaken++;
         }
         else
         {
            stats.numForwardBranchesTaken++;
         }
         branchlast = true;
      }
      else
      {
         if(ri.imm < 0)
         {
            stats.numBackwardBranchesNotTaken++;
         }
         else
         {
            stats.numForwardBranchesNotTaken++;
         }
      }
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      if(imem[pctarget].data_uint() == 0)
      {
         stats.hasUselessBranchDelaySlot++;
      }
      else
      {
         stats.hasUsefulBranchDelaySlot++;
      }
      break;
   case OP_ORI:
      rf.write(ri.rt, rf[ri.rs] | (signExtend16to32ui(ri.imm)));
      if(loadlast == true)
      {
         if(rt.rs == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
   case OP_LUI:
      rf.write(ri.rt, (signExtend16to32ui(ri.imm)<<16));
      loadlast = true;
      loadregister = ri.rt;
      break;
   case OP_J: /*Subtract 4 to avoid increasing PC after Jump*/
      branchpc = (pctarget & 0xF0000000) | ((rj.target)<<2);
      branchlast = true;
      //pc.write(((pctarget - 4) & 0xF0000000) | ((rj.target)<<2));
      break;
   case OP_JAL: /*Subtract 4 to avoid increasing PC after Jump*/
      rf.write(31, pctarget + 4);
      branchpc = (pctarget & 0xF0000000) | ((rj.target)<<2);
      branchlast = true;
      //pc.write(((pctarget - 4) & 0xF0000000) | ((rj.target)<<2));
      break;
   case OP_SB:
      addr = rf[ri.rs] + signExtend16to32ui(ri.imm);
      caches.access(addr);
      temp = dmem[addr];
      temp.set_data_ubyte4(0, rf[ri.rt]); //Set byte 0 to rt
      dmem.write(addr, temp);
      if(loadlast == true)
      {
         if(rt.rs == loadregister || rt.rt == loadregister)
         {
            stats.loadHasLoadUseHazard++;
         }
         else
         {
            stats.loadHasNoLoadUseHazard++;
         }
      }
      loadlast = false;
      break;
   case OP_LB:
      addr = rf[ri.rs] + signExtend16to32ui(ri.imm);
      caches.access(addr);
      temp = dmem[addr];
      rf.write(ri.rt, signExtend8to32ui(temp.data_ubyte4(0))); //Get byte 0
      loadlast = true;
      loadregister = ri.rt;
      break;
   case OP_LBU:
      addr = rf[ri.rs] + signExtend16to32ui(ri.imm);
      caches.access(addr);
      temp = dmem[addr];
      rf.write(ri.rt,temp.data_ubyte4(0)); //Get byte 0
      loadlast = true;
      loadregister = ri.rt;
      break;
  default:
    cout << "Unsupported instruction: ";
    instr.printI(instr);
    exit(1);
    break;
  }
}

