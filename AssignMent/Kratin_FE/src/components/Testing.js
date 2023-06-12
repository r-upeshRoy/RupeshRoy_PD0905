import React from "react"
import myImage from "./kratinFrontPage.jpg"

const Testing = () => {

  

    const imageStyles = {
      width: '1500px',
      height: 'auto',
      borderRadius: '30px',
      boxShadow: '2px 2px 4px rgba(0, 0, 0, 0.2)',
      margin: '20px'
    };
    return (
        <div >
          <img src={myImage} alt="Image description" style={imageStyles} />
        </div>
    )
}

export default Testing;