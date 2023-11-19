import Head from "next/head";
import React, {useState} from "react";
import {useRouter} from "next/router";
import ModalComponent from "@/components/ModalComponent";
import {http} from "@/utils/http";

const DeleteDespesa = () => {

    const [modalIsOpen, setModalIsOpen] = useState(false);

    const openModal = () => {
        setModalIsOpen(true);
    };

    const closeModal = () => {
        setModalIsOpen(false);
        router.push('/gestao-sgme/financeiro/contas-a-pagar')
    };

    const [status, setStatus] = useState([false])

    const router = useRouter();
    const {codigo} = router.query;

    const [despesaId, setDespesaId] = useState(codigo);

    const handleDeleteDespesa = () => {

        http
            .delete(`/despesas/${despesaId}`)
            .then(() => {
                setStatus(true)
            })
            .catch((error) => {
                console.error("Erro ao excluir despesa:" + error);
            });
    };

    const handlerCancelar = () => {
        router.push("/gestao-sgme/financeiro/contas-a-pagar");
    }


    return (
        <>
            <Head>
                <title>SGME - Excluindo despesa</title>
                <meta name="description" content="Generated by create next app"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <link rel="icon" href="/favicon.ico"/>
            </Head>

            <div className="container d-flex flex-column align-items-center justify-content-center">
                <div className="p-5 border border-danger mt-5">
                    <h1 className="text-center mb-3">Excluir receita</h1>
                    <table style={{marginLeft: "20px"}}>
                        <tbody>
                        <tr>
                            <td>
                                <label>Deseja excluir a despesa?</label>
                            </td>
                            <td>
                                <input
                                    type="hidden"
                                    value={despesaId}
                                    onChange={(e) => setDespesaId(e.target.value)}
                                />
                            </td>
                        </tr>
                        <tr>
                            <td colSpan="2">
                                <button className="btn btn-danger mt-2 me-2" onClick={(e) => {
                                    e.preventDefault()
                                    handleDeleteDespesa()
                                    openModal()
                                }}>Confirmar
                                </button>
                                <button className="btn btn-success mt-2" onClick={(e) => {
                                    e.preventDefault();
                                    handlerCancelar()
                                }}>Cancelar</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <ModalComponent
                    isOpen={modalIsOpen}
                    onRequestClose={closeModal}
                >
                    {status===true ? (
                        <div>
                            <p className="fw-bold text-success">Conta excluida com sucesso</p>
                        </div>

                    ):(
                        <p>Erro ao deletar</p>
                    )}


                </ModalComponent>

            </div>
        </>
    )
};

export default DeleteDespesa;