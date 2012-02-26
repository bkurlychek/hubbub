package com.grailsinaction

class UserController {
    def scaffold = true
    def index() {redirect(action:'list') }
}
