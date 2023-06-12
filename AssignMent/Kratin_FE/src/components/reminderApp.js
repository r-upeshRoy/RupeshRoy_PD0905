import React, { useState, useEffect } from 'react';
import Clock from 'react-clock';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


// Import alarm sound file
import alarmSound from './alarm.mp3';

const ReminderApp = () => {
  const [selectedTime, setSelectedTime] = useState(new Date());
  const [currentTime, setCurrentTime] = useState(new Date());
  const [reminderMessage, setReminderMessage] = useState('');
  const [audio, setAudio] = useState(null);
  const [autoplayTriggered, setAutoplayTriggered] = useState(false);

  const handleTimeChange = (time) => {
    setSelectedTime(time);
  };

  const handleSetReminder = () => {
    if (selectedTime <= currentTime) {
      toast.error('Please select a future time');
    } else {
      const message = reminderMessage.trim() || 'No message specified';
      toast.success(`Reminder set for ${selectedTime.toString()}. Message: ${message}`);
    }
  };

  const handleInputChange = (e) => {
    const { value } = e.target;
    setReminderMessage(value);
  };

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentTime(new Date());
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  useEffect(() => {
    const audioElement = new Audio(alarmSound);
    setAudio(audioElement);
  }, []);

  useEffect(() => {
    if (selectedTime <= currentTime && !autoplayTriggered) {
      playAlarmSound();
      setAutoplayTriggered(true);
    }
  }, [selectedTime, currentTime, autoplayTriggered]);

  const playAlarmSound = () => {
    if (audio) {
      audio.play().catch((error) => {
        console.log('Failed to play audio:', error);
      });
    }
  };

  return (
    <div className="app-container">
      <h1>Alarm Reminder App</h1>
      <div className="clock-container">
        <Clock value={currentTime} size={200} />
        <input type="time" onChange={handleTimeChange} />
      </div>
      <input type="text" placeholder="Enter your reminder message" value={reminderMessage} onChange={handleInputChange} />
      <button onClick={handleSetReminder}>Set Reminder</button>
      <button onClick={playAlarmSound}>Play Sound</button>
      <ToastContainer position="top-center" autoClose={3000} hideProgressBar />
    </div>
  );
};

export default ReminderApp;






// import React, { useState, useEffect } from 'react';
// import Clock from 'react-clock';
// import { ToastContainer, toast } from 'react-toastify';
// import 'react-toastify/dist/ReactToastify.css';


// // Import alarm sound file
// import alarmSound from './alarm.mp3';

// const ReminderApp = () => {
//   const [selectedTime, setSelectedTime] = useState(new Date());
//   const [currentTime, setCurrentTime] = useState(new Date());
//   const [reminderMessage, setReminderMessage] = useState('');

//   const handleTimeChange = (time) => {
//     setSelectedTime(time);
//   };

//   const handleSetReminder = () => {
//     if (selectedTime <= currentTime) {
//       toast.error('Please select a future time');
//     } else {
//       const message = reminderMessage.trim() || 'No message specified';
//       toast.success(`Reminder set for ${selectedTime.toString()}. Message: ${message}`);
//     }
//   };

//   const handleInputChange = (e) => {
//     const { value } = e.target;
//     setReminderMessage(value);
//   };

//   useEffect(() => {
//     // Preload audio file
//     const audio = new Audio(alarmSound);
//     audio.load();
//   }, []);

//   const playAlarmSound = () => {
//     const audio = new Audio(alarmSound);
//     audio.play();
//   };

//   return (
//     <div className="app-container">
//       <h1>Alarm Reminder App</h1>
//       <div className="clock-container">
//         <Clock value={currentTime} size={200} />
//         <input type="time" onChange={handleTimeChange} />
//       </div>
//       <input type="text" placeholder="Enter your reminder message" value={reminderMessage} onChange={handleInputChange} />
//       <button onClick={handleSetReminder}>Set Reminder</button>
//       <ToastContainer position="top-center" autoClose={3000} hideProgressBar />
//       {/* Hidden audio element for playing the alarm sound */}
//       <audio src={alarmSound} preload="auto" />
//       <button onClick={playAlarmSound}>Play Sound</button>
//     </div>
//   );
// };

// export default ReminderApp;



// import React, { useState } from 'react';
// import Clock from 'react-clock';
// import { ToastContainer, toast } from 'react-toastify';
// import 'react-toastify/dist/ReactToastify.css';


// const ReminderApp = () => {
//   const [selectedTime, setSelectedTime] = useState(new Date());
//   const [currentTime, setCurrentTime] = useState(new Date());
//   const [reminderMessage, setReminderMessage] = useState('');

//   const handleTimeChange = (time) => {
//     setSelectedTime(time);
//   };

//   const handleSetReminder = () => {
//     if (selectedTime <= currentTime) {
//       toast.error('Please select a future time');
//     } else {
//       const message = reminderMessage.trim() || 'No message specified';
//       toast.success(`Reminder set for ${selectedTime.toLocaleTimeString()}. Message: ${message}`);
//     }
//   };

//   const handleInputChange = (e) => {
//     const { value } = e.target;
//     setReminderMessage(value);
//   };

//   return (
//     <div >
//       <h1>Alarm Reminder App</h1>
//       <div> <h5>select Reminder Time</h5></div>
//       <div>
//         <Clock value={currentTime} size={200} />
//         <input type="time" onChange={handleTimeChange} />
//       </div>
//       <input type="text" placeholder="Enter your reminder message" value={reminderMessage} onChange={handleInputChange} />
//       <button onClick={handleSetReminder}>Set Reminder</button>
//       <ToastContainer position="top-center" autoClose={3000} hideProgressBar />
//     </div>
//   );
// };

// export default ReminderApp;
