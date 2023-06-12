import React, { useState } from "react"
import "./register.css"
import axios from "axios"
import { useHistory } from "react-router-dom"

const Register = () => {

    const history = useHistory()
    const [ user, setUser] = useState({
        name: "",
        email:"",
        password:"",
        gender: "",
        age:"",
        mobileNumber:""
    
    })
    
    const handleChange = e => {
        const { name, value } = e.target
        setUser({...user,[name]: value })
    }

    const register = () => {
        const { email, password } = user
        if(email && password){
            axios.post("http://localhost:9090/user/addUser", user)
          
            .then( (res) => {
                console.log(res.data)
                alert("registered successfully")
                history.push("/login")
            })
        } else {
            alert("invalid input")
        }    
    }

    return (
        <div className="register">
            {console.log("User", user)}
            <h1>Register</h1>
            <input type="text" name="name" value={user.name} placeholder="Full Name" onChange={ handleChange }></input>
            <input type="text" name="email" value={user.email} placeholder="Your Email" onChange={ handleChange }></input>
            <input type="password" name="password" value={user.password} placeholder="Your Password" onChange={ handleChange }></input>
            <input type="text" name="gender" value={user.gender} placeholder="Gender" onChange={ handleChange }></input>
            <input type="number" name="age" value={user.age} placeholder="Your Age" onChange={ handleChange }></input>
            <input type="number" name="mobileNumber" value={user.mobileNumber} placeholder="Your Mobile No." onChange={ handleChange }></input>

            <div className="button" onClick={register}>Register</div>
            
        </div>
    )
}

export default Register





   {/* <label for="state">State   </label>
                <select name="state" id="state">
                  <option value="Maharashtra">Maharashtra</option>
                  <option value="Orissa">Orissa</option>
                  <option value="West Bengal">West Bengal</option>
                  <option value="Uttar Pradesh">Uttar Pradesh</option>
                </select> */}