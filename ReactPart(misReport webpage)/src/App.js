import React from 'react';
import './App.css';
//Calling Bootstrap 4.5 css
import 'bootstrap/dist/css/bootstrap.min.css';
//Calling Firebase config setting to call the data
import firebase from './Firebase';
class App extends React.Component {
constructor(props) {
    
    super(props);
   
    this.state = {planned : [],actual:[], subdate:''}

    //this.handleChange = this.handleChange.bind(this);
    //this.handleSubmit = this.handleSubmit.bind(this);
    }
   
    
  /*componentDidMount() {
   
   
     
      firebase.database().ref('Planned Details').orderByChild('plandate').equalTo(`${this.state.subdate} `).on('value', snapshot => {
        let pdetails = [];
        snapshot.forEach(snap => {
            pdetails.push(snap.val());
        });
        console.log(snapshot.val())
        this.setState({ planned: pdetails });
        console.log(pdetails)
      });

      firebase.database().ref('Actual Details').orderByChild('productiondate').equalTo(`${this.state.subdate} `).on('value', snapshot => {
        let adetails = [];

        snapshot.forEach(snap => {
            adetails.push(snap.val());
        });
        this.setState({ actual: adetails });
      });
    
    
 }*/

 handlesubdateChange = event => {
  this.setState({
    subdate: event.target.value
  })
}

/* handleChange(event) {
  this.setState({subdate: event.target.value});
}*/

handleSubmit = event => {
  alert(`${this.state.subdate} `)
  firebase.database().ref('Planned Details').orderByChild('plandate').equalTo(`${this.state.subdate}`).once('value', snapshot => {
    let pdetails = [];
    snapshot.forEach(snap => {
        pdetails.push(snap.val());
    });
    console.log(snapshot.val())
    this.setState({ planned: pdetails });
    console.log(pdetails)
  });

  firebase.database().ref('Actual Details').orderByChild('productiondate').equalTo(`${this.state.subdate}`).once('value', snapshot => {
    let adetails = [];

    snapshot.forEach(snap => {
        adetails.push(snap.val());
    });
    this.setState({ actual: adetails });
  });
  event.preventDefault()
}
  
  render(){
  const { subdate } = this.state
  return (
    <div className="MainDiv " id="t1">
      <div className="container ">
        <div class="jumbotron mb-5" data-bs-toggle="collapse" >
            <h3>MIS Report</h3>
            <p>Enter date (dd/mm/yyyy)</p>
            <form onSubmit={this.handleSubmit}>
                <div>
                  <input
                    type="text"
                    value={subdate}
                    onChange={this.handlesubdateChange}
                  />
                </div>
                <button type="submit">Submit</button>
              </form>
        </div>
      </div>
      
      <div className="container " >
        <div className="child">
            <table id="example" class="display table" >
              <thead class="thead-dark">
                  <tr>
                      <th>Order No.</th>
                      <th>Production Date</th>
                      <th>Production Unit</th>
                      <th>Planned Grade</th>
                      <th>Planned tonnage</th>
                  </tr>
              </thead>
              <tbody>
              {this.state.planned.map(data => {
                  
                  return (
                      <tr>     
                      <td>{data.ordernum}</td>
                      <td>{data.plandate}</td>
                      <td>{data.productionunit}</td>
                      <td>{data.grade}</td>
                      <td>{data.tonnage}</td>
                      
                      </tr>
                      
                  );
                
                  })}
          
                
              </tbody>
              
          </table>
            
          
            
      </div>
     
     <div className="child">
          <table id="example" class="display table" >
            <thead class="thead-dark">
                <tr>
                    <th>Produced Grade</th>
                    <th>Produced tonnage</th>
                    <th>Remarks</th>
                </tr>
            </thead>
            <tbody>
            {this.state.actual.map(data => {
                
                return (
                    <tr>     
                    <td>{data.finalgrade}</td>
                    <td>{data.tonnage}</td>
                    <td>{data.remarks}</td>
                    
                    </tr>
                    
                );
               
                })}
        
               
            </tbody>
            
         </table>
          
      </div>
    </div>
    </div> 
    
  );
}
}
export default App;