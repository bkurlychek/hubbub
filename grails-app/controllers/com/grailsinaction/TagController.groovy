package com.grailsinaction

class TagController {
    def scaffold = true
    def index = {
        redirect(action:'list')  
    }
}
