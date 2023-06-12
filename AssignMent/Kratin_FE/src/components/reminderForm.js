import React, { useState } from 'react';

const ReminderForm = ({ addReminder, hour }) => {
  const [reminder, setReminder] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (reminder.trim() === '') return;
    const newReminder = {
      id: Date.now(),
      text: reminder,
      hour: hour,
    };
    addReminder(newReminder);
    setReminder('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        placeholder="Enter reminder"
        value={reminder}
        onChange={(e) => setReminder(e.target.value)}
      />
      <button type="submit">Add Reminder</button>
    </form>
  );
};

export default ReminderForm;
