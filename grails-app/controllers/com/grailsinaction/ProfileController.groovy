package com.grailsinaction

class ProfileController {
    def scaffold = true
    def index = {
        redirect(action:'list')  
    }
}
