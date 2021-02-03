//import logo from './logo.svg';
import './App.css';
import {default as ListAdminsComponent} from './components/ListAdminsComponent';
import ListOrderComponent from './components/ListOrderComponent';

function App() {
  return (
    <div className="container">
      <switch>
      <ListAdminsComponent/>
      <Route path ="/orders" component = {ListOrderComponent}></Route></switch>
    </div>
  );
}

export default App;
