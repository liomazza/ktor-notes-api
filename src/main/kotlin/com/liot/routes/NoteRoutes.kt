package com.liot.routes

import com.liot.data.getNotesForUser
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.response.*
import io.ktor.routing.*

fun Route.noteRoutes() {
    route("/getnotes") {
        authenticate {
            get {
                val email = call.principal<UserIdPrincipal>()!!.name
                val notes = getNotesForUser(email)
                call.respond(OK, notes)
            }
        }
    }
}