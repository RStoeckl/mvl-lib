cmake_minimum_required()

add_executable(mvllib main.cpp)

install(TARGETS mvllib RUNTIME DESTINATION bin)
