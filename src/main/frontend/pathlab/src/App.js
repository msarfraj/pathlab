import React from 'react';
import './App.css';
import axios from 'axios';

export default class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      // persons: []
    }
  }

  componentDidMount() {
    axios.get(`http://localhost:8080/registeredDocs`)
      .then(res => {
        const persons = res.data;
        console.log('-----------', persons)
      })
  }

  render() {
    return (
      <div className="App">
        <div className="content">
            <div className="container">
                <div className="starter-template">
                    <div className="data">
                        <div className="row">
                            <div className="head_text">Name</div>
                            <div className="head_text">mohsin</div>
                            <div className="head_text">Hospital</div>
                        </div>
                        <div className="row">
                            <div className="data_text" >123</div>
                            <div className="data_text">123</div>
                            <div className="data_text">123</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
      </div>
    );
  }
}
