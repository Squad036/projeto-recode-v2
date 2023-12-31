import React, {useEffect, useState} from 'react';
import Link from "next/link";
import {http} from "@/utils/http";
import Head from "next/head";
import Paginacao from "@/components/Paginacao";

function Index(props) {

    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState(1);

    const [fornecedores, setFornecedores] = useState([]);

    useEffect(() => {
        http.get(`/fornecedores?page=${page}&size=10`, {params: {page}})
            .then((response) => {
                setFornecedores(response.data.content)
                setTotalPages(response.data.totalPages)
            })
            .catch((error) => {
                console.error("Erro ao buscar a lista de fornecedores", error)
            });
    }, [page]);


    return (
        <>
            <Head>
                <title>SGME-Fornecedores</title>
                <meta name="description" content="Generated by create next app"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <link rel="icon" href="/favicon.ico"/>
            </Head>

            <main className="container">
                <div className="container d-sm-flex flex-row justify-content-between mb-3">
                    <h3>Clientes</h3>
                    <Link href="/gestao-sgme/fornecedores/cadastro" className="btn btn-success">Novo Fornecedor</Link>
                </div>
                <table className="table">
                    <thead>
                    <tr className="border border-2 border-warning">
                        <th scope="col">Razao Social / Nome</th>
                        <th scope="col">Cnpj / Cpf</th>
                        <th scope="col" className="d-flex justify-content-end">Ações</th>


                    </tr>
                    </thead>
                    <tbody>

                    {fornecedores && fornecedores.length > 0 ? (
                            fornecedores.map(fornecedor =>
                                <tr key={fornecedor.id}>

                                    <td>
                                        {fornecedor.nome}
                                    </td>
                                    <td> {fornecedor.codigo}</td>
                                    <td className="d-flex  justify-content-end ">
                                        <Link href={`/gestao-sgme/fornecedores/update/${fornecedor.id}`}
                                              className="btn btn-success me-2">EDITAR</Link>
                                    </td>
                                </tr>
                            )
                        ) :
                        (
                            <tr>
                                <td colSpan="6">Nenhum cliente encontrado.</td>
                            </tr>
                        )}


                    </tbody>
                </table>

                <Paginacao  page={page} totalPages={totalPages} setPage={setPage}/>
            </main>
        </>

    );
}

export default Index;