!
! Use linear interpolation to compute the freezing point of seawater.
!
 PROGRAM seawater

!  * Input Variables *
   INTEGER salinity1
   INTEGER salinity2
   INTEGER newsalinity
   REAL    temp1
   REAL    temp2

!  * Computed Result *
   REAL    predictedtemp


!  Obtain input data

   PRINT *, "For data entry, salinity units are parts per thousand (integer)"
   PRINT *, "temperature is degrees Fahrenheit (floating point)."
   PRINT *, "Enter first observed salinity and temperature: "
   READ  *, salinity1, temp1
   PRINT *, "Enter second observed salinity and temperature: "
   READ  *, salinity2, temp2
   PRINT *, "Enter new salinity: "
   READ  *, newsalinity

!  Perform computation

   predictedtemp = temp1 + REAL(newsalinity-salinity1)/(salinity2-salinity1) * (temp2 - temp1)

!  Display result

   WRITE (*,*) "Interpolated freezing temperature: ", predictedtemp

 END PROGRAM seawater


