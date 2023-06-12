import axios from 'axios';
import React, { useEffect } from 'react';
import ReminderForm from './reminderForm';
import 'bootstrap/dist/css/bootstrap.css';
import './userData.css'


const UserData = () => {
    
    const sessionData = sessionStorage.getItem('user')
    const data = JSON.parse(sessionData);
          
  // init the data
  const userId = data.userId;
  const name = data.name;
  const email = data.email;
  const diseases = data.diseases;
  const reminders = data.reminders;
  const mobileNumber = data.mobileNumber;

  const reminderFormUrl = () =>{
    window.location.href = '/reminderApp'
  }

  
  const sendSms = (reminder) =>{
    const message = reminder.taskName
    const time = reminder.duration
    const sms = {
      toPhoneNumber: "+919545152061",
      message : message,
      sendTime : time
    }
    console.log(sms)
    axios.post('http://localhost:9090/send-sms', sms)
      .then(response => {
        console.log('SMS sent successfully');
      })
      .catch(error => {
        if (error.response) {
          console.error('Error sending SMS:', error.response.data);
          console.error('Status:', error.response.status);
          console.error('Headers:', error.response.headers);
        } else {
          console.error('Error sending SMS:', error.message);
        }
      });
      
  }

 
  return (
    <div className="my-component-container">
      <h1/>
      <button onClick={reminderFormUrl}>Reminder</button>
      <h2 className="mt-5">User Details</h2> 
      <p>User ID: {userId}</p>
      <p>Name: {name}</p>
      <p>Email: {email}</p>
      <p>mobile Number: {mobileNumber}</p>



      <h2 className="mt-4">Diseases</h2>
      {diseases.map((disease) => (
        <div key={disease.d_Id} className="disease-container">
          <h4 className="disease-name">Disease Name: {disease.diseaseName} </h4>
          <p>Disease Description: {disease.diseaseDescription}</p>
          
          <h5>Medicines</h5>
          {disease.medicines.map((medicine) => (
            <div key={medicine.m_Id} className="medicine-container">
              <p className="medicine-name">Medicine Name: {medicine.medicineName}</p>
              
              <h6>Medicine Times</h6>
              {medicine.medTimes.map((medTime) => (
                <div key={medTime.t_Id} className="med-time-container ">
                  <p>Date and Time: {medTime.dateTime}</p>
                </div>
              ))}
            </div>
          ))}
        </div>
      ))}

      <h2 className="mt-4">Reminders</h2>
      {reminders.map((reminder) => (
        <div key={reminder.r_Id} className="reminder-container">
          <p>Task Name: {reminder.taskName}</p>
          <p>Duration: {reminder.duration}</p>
          <button className="btn btn-primary" onClick={() => sendSms(reminder)}>send Sms</button>
        </div>
      ))}
    </div>

    
  );
};

export default UserData;
