import React from 'react';

import api from '../../services/api';
import './styles.css';


function Administrador() {
    const [process, setProcess] = React.useState([]);

    const getProcessos = async () => {
        const response =  await api.get(`process/getAll`);
        setProcess(response.data);
    }  

    const insertProcess = ( ) => {
        window.location.href = `/triador/cadastro`;
    }

    React.useEffect(() => {
        getProcessos();
    }, []);

    return (
        <div id="box-container">
            <header>
                <h1>Processos</h1>
            </header>

            <ul>
                <li>
                    <h3>Descrição</h3>
                    <button onClick={() => insertProcess()}>Incluir</button>
                </li>
                
                {process.map(processo => (
                    <li key={processo.idprocess}>
                        <h5 id="dados">{processo.description}</h5>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Administrador;
