echo off
set path=D:\JDK\jdk-14.0.2\bin
set D:\JDK\jdk-14.0.2\include
set lib=D:\JDK\jdk-14.0.2\lib
set link=D:\JDK\jdk-14.0.2\bin
javac -version Initials.java
java Initials
javap -c Initials >bite_code.txt
javadoc Initials.java -d 1
pause