package org.adaschool.TaskPlanner.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
class UserNotFoundException: RuntimeException()
