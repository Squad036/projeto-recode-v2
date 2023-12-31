import React from 'react';
import Head from "next/head";
import Image from "next/image";
import CardImagemButton from "@/components/cards/CardImagemButton";

function Index(props) {


    return (
        <>
            <Head>
                <title>SGME - Fale conosco</title>
                <meta name="description" content="Generated by create next app"/>
                <meta name="viewport" content="width=device-width, initial-scale=1"/>
                <link rel="icon" href="/favicon.ico"/>
            </Head>
            <main className="container">
                <section className="container mb-5 mt-5">
                    <div className="d-lg-flex">
                        <div className="p-4">
                            <h1 className="text-center mb-4">Atendimento</h1>
                            <p className="fs-5 text-center">
                                Envie uma Mensagem ou acesse nossos canais de atendimento disponiveis para você!
                                Encontre uma ONG perto de você, ou acesse nossa base de conhecimento para ficar por
                                dentro de como gerir melhor o seu negócio.
                            </p>
                        </div>
                        <div className="d-sm-flex align-items-center justify-content-end">
                            <Image
                                src="/img/page_contato.png"
                                width={350}
                                height={275}
                                alt="atendimento"
                            />
                        </div>
                    </div>
                </section>

                <section className="container mb-5">
                    <h1 className="text-center text-paleta_blue mb-5">
                        Atendimento para o seu negócio
                    </h1>

                    <div className="container-sm d-sm-flex flex-wrap justify-content-between">
                        <CardImagemButton img="/img/Ongs_parceiras.svg" link="#" titleLink="Ongs Parceiras"/>
                        <CardImagemButton img="/img/base_conhecimento.svg" link="/blogSgme" titleLink="Blog SGME"/>
                        <CardImagemButton img="/img/manual.jpg" link="#" titleLink="Manual Sistema"/>
                        <CardImagemButton img="/img/chat.svg" link="#" titleLink="Chat"/>
                    </div>
                </section>

                <section className="container-sm mb-5 ">
                    <div className="container-sm">
                        <div className="container-sm d-sm-flex">
                            <div className="">
                                <Image
                                    src="/img/icone form-contato.jpg"
                                    alt="contatoform"
                                    width={350}
                                    height={350}
                                />
                            </div>

                            <div className="w-100">
                                <h2 className="mb-4">Contate-nos</h2>

                                <div className="form">
                                    <input
                                        type="name"
                                        className="form-control mb-3 border border-primary"
                                        id="inputNome"
                                        placeholder="Nome"
                                    />
                                    <input
                                        type="email"
                                        className="form-control mb-3 border border-primary"
                                        id="inputEmail"
                                        placeholder="Email@example.com"
                                    />
                                    <textarea
                                        className="form-control mb-3 border border-primary"
                                        id="textarea"
                                        rows="3"
                                        placeholder="Digite Aqui sua Mensagem"
                                    ></textarea>
                                    <button className="btn btn-primary w-100" type="button">
                                        Enviar
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

            </main>
        </>
    );
}

export default Index;