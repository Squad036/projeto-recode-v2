import {useRouter} from "next/router";
import React, {useEffect, useState} from "react";
import axios from "axios";
import Head from "next/head";
import {http} from "@/utils/http";
import ModalComponent from "@/components/ModalComponent";
import ButtonFechar from "@/components/ButtonFechar";

const UpdateReceita = () => {
    const router = useRouter();

    const [modalIsOpen, setModalIsOpen] = useState(false);

    const openModal = () => {
        setModalIsOpen(true);
    };

    const closeModal = () => {
        setModalIsOpen(false);
        router.push('/gestao-sgme/financeiro/contas-a-receber')
    };

    const {codigo} = router.query;
    const [receita, setReceita] = useState({
        id: {codigo},
        cliente_id: "",
        valor: "",
        status: "",
        forma_pagamento: "",
        data_vencimento: "",
    });

    const [cliente, setCliente] = useState(
        {
            nome: "",
        }
    );

    const [status, setStatus] = useState([false]);


    useEffect(() => {
        if (codigo) {
            http.get(`/receitas/${codigo}`)
                .then((response) =>
                    setReceita(response.data)
                )
                .catch((error) => {
                    console.log("Erro ao buscar receita" + error)
                })
        }

    }, [codigo])


    useEffect(() => {
        if (receita.cliente_id) {

        }
        http.get(`/clientes/${receita.cliente_id}`)
            .then((response) => setCliente(response.data))
            .catch((error) => console.log("Erro ao buscar cliente" + error))
    }, [receita.cliente_id])

    console.log(cliente)
    const handleUpdateReceita = async () => {

        try {
            await http
                .put(`/receitas/${codigo}`, receita)
                .then((response) => {
                    setStatus(true)
                })
        } catch (error) {
            if (axios.isAxiosError(error) && error.response) {
                console.error('Erro na resposta da API:', error.response.data);
            } else {
                console.error('Erro ao enviar dados para a API:', error);
            }
        }
    };


    const handleInputChange = (e) => {
        setReceita({...receita, [e.target.name]: e.target.value});
        console.log(receita)
    };

    const handlerCancelar = () => {
        router.push('/gestao-sgme/financeiro/contas-a-receber');
    }


    return (
        <>
            <Head>
                <title>SGME - Alterando Receitas</title>
                <meta name="description" content="Generated by create next app"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <link rel="icon" href="/favicon.ico"/>

            </Head>
            <div className="container d-flex align-items-center justify-content-center mt-5">

                <form className="form-control p-5">
                    <ButtonFechar url="/gestao-sgme/financeiro/contas-a-receber" />
                    <h1>Alterando a receita</h1>
                    <input value={cliente.id}
                           name="cliente_id"
                           hidden
                           onChange={handleInputChange}

                    />
                    <div className="d-flex flex-column ">
                        <label>Cliente</label>
                        <input className="form-control"
                               value={cliente.nome}
                        />
                    </div>

                    <div className="d-sm-flex flex-row justify-content-between mb-3">
                        <div className="d-flex flex-column w-100 me-3">
                            <label htmlFor="valor">Valor: </label>
                            <input placeholder="R$"
                                   className="form-control"
                                   value={receita.valor}
                                   name="valor"
                                   onChange={handleInputChange}
                            />

                        </div>


                        <div className="d-flex flex-column w-100">
                            <label htmlFor="data_vencimento">Data Vencimento: </label>
                            <input type="date"
                                   className="form-control"
                                   value={receita.data_vencimento}
                                   name="data_vencimento"
                                   onChange={handleInputChange}
                            />

                        </div>
                    </div>

                    <div className="d-sm-flex flex-row justify-content-between mb-3">

                        <div className="d-flex flex-column w-100 me-3">
                            <label htmlFor="forma_pagamento">Forma de Pagamento</label>
                            <select className="form-select"
                                    value={receita.forma_pagamento}
                                    name="forma_pagamento"
                                    onChange={handleInputChange}
                            >
                                <option hidden value={receita.forma_pagamento}>{receita.forma_pagamento}</option>
                                <option value="DINHEIRO">DINHEIRO</option>
                                <option value="PIX">PIX</option>
                                <option value="CARTAO">CARTAO</option>
                                <option value="BOLETO">BOLETO</option>
                            </select>


                        </div>

                        <div className="d-flex flex-column w-100">
                            <label htmlFor="status">Status</label>
                            <select className="form-select"
                                    value={receita.status}
                                    name="status"
                                    onChange={handleInputChange}
                            >
                                <option value={receita.status} hidden>{receita.status}</option>
                                <option value="A PAGAR">A PAGAR</option>
                                <option value="PAGA">PAGA</option>
                            </select>

                        </div>

                    </div>

                    <button className="btn btn-success me-3" onClick={(e) => {
                        e.preventDefault()
                        handleUpdateReceita()
                        openModal()
                    }}>ALTERAR
                    </button>
                    <button className="btn btn-danger " onClick={handlerCancelar}>CANCELAR</button>


                    <ModalComponent
                        isOpen={modalIsOpen}
                        onRequestClose={closeModal}
                    >
                        {status===true ? (
                            <div>
                                <p className="fw-bold text-success">Conta alterada com sucesso</p>
                            </div>

                        ):(
                            <p>Erro ao atualizar</p>
                        )}


                    </ModalComponent>
                </form>

            </div>
        </>
    )
}

export default UpdateReceita;