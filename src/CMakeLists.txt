#file(GLOB 
#  data/*.h
#  data/*.cpp
#)

add_executable(mvllib main.cpp)

install(TARGETS mvllib RUNTIME DESTINATION bin)