onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -format Logic /proc2test/break_in
add wave -noupdate -format Logic /proc2test/sys_on_l
add wave -noupdate -format Logic /proc2test/clock
add wave -noupdate -format Logic /proc2test/sys_armed
add wave -noupdate -format Logic /proc2test/alarm
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {2530870 ps} 0}
configure wave -namecolwidth 150
configure wave -valuecolwidth 100
configure wave -justifyvalue left
configure wave -signalnamewidth 0
configure wave -snapdistance 10
configure wave -datasetprefix 0
configure wave -rowmargin 4
configure wave -childrowmargin 2
configure wave -gridoffset 0
configure wave -gridperiod 1
configure wave -griddelta 40
configure wave -timeline 0
update
WaveRestoreZoom {0 ps} {7479286 ps}
