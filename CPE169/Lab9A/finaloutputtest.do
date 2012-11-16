onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -format Literal -expand /alarmtest/btns
add wave -noupdate -format Literal -expand /alarmtest/accesscode
add wave -noupdate -format Literal -expand /alarmtest/usercode
add wave -noupdate -format Literal -expand /alarmtest/cs
add wave -noupdate -format Literal -expand /alarmtest/an
add wave -noupdate -format Logic /alarmtest/dp
add wave -noupdate -format Logic /alarmtest/sys_armed
add wave -noupdate -format Logic /alarmtest/alarm
add wave -noupdate -format Logic /alarmtest/mclk
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {2965275 ps} 0}
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
WaveRestoreZoom {0 ps} {3739646 ps}
