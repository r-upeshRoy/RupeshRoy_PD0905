import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter } from 'react-router-dom';
import NavbarCompo from './components/NavbarCompo';


function App() {
  return (
      <BrowserRouter>
         <NavbarCompo/>
      </BrowserRouter>
     
  );
}

export default App;
