import React, {useState} from "react"
import "./login.css"
import axios from "axios"
import { useHistory } from "react-router-dom"

const Login = () => {

    const history = useHistory()

    const [ user, setUser] = useState({
        email:"",
        password:""
    })

    const handleChange = e => {
        const { name, value } = e.target
        setUser({...user, [name]: value})
    }

    const login = () => {
        const { email, password } = user
        if(email && password){
            axios.post("http://localhost:9090/user/login", user)
          
            .then( (response) => {
                console.log(response.data)
                const data = response.data
                if(data != null){
                    sessionStorage.setItem('user',JSON.stringify(data))
                    alert("logged in successfully")
                    window.location.href  = '/userData'
                    history.push("/")
                }
                
               
            }) .catch(error => {
                console.error('Error retrieving user data:', error);
                alert("invalid credentials")
              });
        } else {
            alert("enter email and password")
        }    
    }


    return (
        <div className="login">
            <h1>Login</h1>
            <input type="text" name="email" value={user.email} onChange={handleChange} placeholder="Enter your Email"></input>
            <input type="password" name="password" value={user.password} onChange={handleChange}  placeholder="Enter your Password" ></input>
            <div className="button" onClick={login}>Login</div>
          
        </div>
    )
}

export default Login