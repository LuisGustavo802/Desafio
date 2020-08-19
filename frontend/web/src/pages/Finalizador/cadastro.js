import React, { Component } from 'react';

import api from '../../services/api';
import './styles.css';

export default class Main extends Component {
    state = {
        parecer: '',
        feedback: []
    }
    
    handleInputParecerChange = e => {
        this.setState({ parecer: e.target.value });
    }

    handleSubmit = async e => {
        e.preventDefault();

        await api.post("feedbackprocess/update", {
          id: this.state.feedback[0].id,
          iduser: this.state.feedback[0].iduser,
          idprocess: this.state.feedback[0].idprocess,
          fgrevised: "T",
          feedback: this.state.parecer,
        });
        
        this.props.history.push(`/finalizador/${this.state.feedback[0].iduser}`);
    } 

    async componentDidMount() {
  
      const id = this.props.match.params.id;
      
      const response = await api.get(`feedbackprocess/getByProcess/${id}`);
      this.setState({ feedback: response.data });
      console.log(this.state.feedback)
    }        
       
    render() {
      return (
          <div id="main-container">
              <form onSubmit={this.handleSubmit}>
                  <input 
                      placeholder="Parecer"
                      value={this.state.parecer}
                      onChange={this.handleInputParecerChange}
                  />

                  <button type="submit">Gravar</button>
              </form>
          </div>
    );
  }
}