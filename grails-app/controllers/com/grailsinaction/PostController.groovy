package com.grailsinaction

class PostController {
    
    def scaffold = true
    
    def index = {
        if(!params.id)
        params.id = "chuck_norris"
        redirect(action: 'timeline', params:params)
    }
    
    def timeline = { 
    def user = User.findByUserId(params.id)
    [user:user]
    }
    
    def addPost = {
        
        def user = User.findByUserId(params.id)
        if(user){
            def post = new Post(params)
            user.addToPosts(post)
            if(user.save()){
                flash.message="Successfully created Post"
            }else{
                user.discard()
                flash.message= "Field cannot be blank"
                
            }
            redirect (action:'timeline',id: params.id)
            
        }
        
        // left off on 5.2 - Services. 
        
    }
}
