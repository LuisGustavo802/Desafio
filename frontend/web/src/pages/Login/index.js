import React, { Component } from 'react';

import api from '../../services/api';
import './styles.css';

export default class Main extends Component {
    state = {
        user: '',
        password: '',
    }

    handleInputUserChange = e => {
        this.setState({ user: e.target.value });
    }

    handleInputPasswordChange = e => {
        this.setState({ password: e.target.value });
    }
    
    handleSubmit = async e => {
        e.preventDefault();

        const response = await api.post("users/login", {
            username: this.state.user,
            password: this.state.password,
        });

        if ( response.data.accesslevel === "A" ) {
            this.props.history.push(`/administrador`);
        } else if ( response.data.accesslevel === "T" ) {
            this.props.history.push(`/triador`);
        } else if ( response.data.accesslevel === "F" ) {
            this.props.history.push(`/finalizador/${response.data.iduser}`);
        } else {
            alert("Usuário ou senha inválido!");
        }
    }    

    render() {
    return (
        <div id="main-container">
            <form onSubmit={this.handleSubmit}>
                <input 
                    placeholder="Login"
                    value={this.state.user}
                    onChange={this.handleInputUserChange}
                /> 
                <input 
                    placeholder="Senha"
                    type="password"
                    value={this.state.password}
                    onChange={this.handleInputPasswordChange}
                />
                <button type="submit">Entrar</button>
            </form>
        </div>
    );
  }
}