onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -format Logic /procedure1test/a
add wave -noupdate -format Logic /procedure1test/b
add wave -noupdate -format Logic /procedure1test/sum
add wave -noupdate -format Logic /procedure1test/carry
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {600797 ps} 0}
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
WaveRestoreZoom {0 ps} {2244487 ps}
