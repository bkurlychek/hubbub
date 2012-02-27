import com.grailsinaction.*
import grails.util.*

class BootStrap {

    def init = { servletContext ->
        switch (Environment.current){
            case Environment.DEVELOPMENT:
            CreateAdminUserIfRequired()
            break;
            
            case Environment.PRODUCTION:
            println"No special configuration required."
            break;
        }
    }
    def destroy = {
    }
    
    void createAdminUserifRequired(){
        
        if(!User.findByUserId("admin")){
            println"fresh database, creating admin user."
            def profile = new Profile (email: "admin@hubbub.com")
            def user = new User(userId: "admin", 
                password: "secret", profile:profile).save() 
        }else{
            println "existing admin user, skipping creation."
        }
        
    }
}
