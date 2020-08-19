import React from 'react';
import {MdModeEdit} from 'react-icons/md';

import api from '../../services/api';
import './styles.css';


function Administrador() {
    const [process, setProcess] = React.useState([]);

    const getProcessos = async () => {
        let path = window.location.pathname.split('/');
        const user = path[2];

        const response =  await api.get(`feedbackprocess/getByIdUser/${user}`);
        setProcess(response.data);
    }  

    const editProcesso = ( idProcesso ) => {
        window.location.href = `/finalizador/cadastro/${idProcesso}`;
    } 

    React.useEffect(() => {
        getProcessos();
    }, []);

    return (
        <div id="box-container">
            <header>
                <h1>Processos pendetes</h1>
            </header>

            <ul>
                <li>
                    <h3>Código do processo</h3>
                </li>
                
                {process.map(processo => (
                    <li key={processo.id}>
                        <h5 id="dados">{processo.idprocess}</h5>
                        <div id="buttons">
                            <MdModeEdit onClick={() => editProcesso(processo.id)} size={24} color="#3255a5" />
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Administrador;
