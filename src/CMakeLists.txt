cmake_minimum_required(VERSION 2.6)
project(mvllib)
add_executable(mvllib main.cpp)

install(TARGETS mvllib RUNTIME DESTINATION bin)