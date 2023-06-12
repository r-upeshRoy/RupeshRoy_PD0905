import React, { Component } from "react";
import { Navbar, NavDropdown, Nav, Form, Button, Container } from "react-bootstrap";
import {
  BrowserRouter as Router,
  Route,
  Link,
  Switch
} from "react-router-dom";
import Login from "./login";
import Register from "./register";
import Testing from "./Testing";
import "./navbar.css";
import UserData from "./userData";
import ReminderForm from "./reminderForm";
import ReminderApp from "./reminderApp";

export default class NavbarCompo extends Component{
    render(){
        return(
        
         <Router> 
            <div>
                 <Navbar bg="dark" variant={"dark"} expand="lg">
      <Container fluid>
        <Navbar.Brand as={Link} to={"/home"}>Kratin</Navbar.Brand>
        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav
            className="me-auto my-2 my-lg-0"
            style={{ maxHeight: '100px' }}
            navbarScroll
          >
            <Nav.Link as={Link} to={"/home"}>Home</Nav.Link>
            <Nav.Link as={Link} to={"/register"}>Register</Nav.Link>
            <Nav.Link as={Link} to={"/signin"}>Sign In</Nav.Link>
                    {/* <Nav.Link href="#action3">Home</Nav.Link>
                    <Nav.Link href="#action3">Products</Nav.Link> */}
          
          </Nav>
         
        </Navbar.Collapse>
      </Container>
    </Navbar>
            </div>
                
            
         <Switch>
          {/* <Route exact path="/signin"> <Login /> </Route>
          <Route exact path="/register"> <Register /> </Route> */}
          <Route exact path="/home"> <Testing/> </Route>
          <Route exact path="/register"> <Register/> </Route>
          <Route exact path="/signin"> <Login/> </Route>
          <Route exact path="/userData"> <UserData/> </Route>
          <Route exact path="/reminderForm"> <ReminderForm/> </Route>
          <Route exact path="/reminderApp"> <ReminderApp/> </Route>

        </Switch>
          
            </Router>    
        )
    }
}