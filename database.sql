CREATE TABLE t_client_cli
(
    cli_id INT PRIMARY KEY NOT NULL,
    cli_nom VARCHAR(60) NOT NULL,
    cli_prenom VARCHAR(60) NOT NULL,
    cli_numero_tel CHAR(10) NOT NULL,
    cli_email VARCHAR(60) NOT NULL,
    cli_adresse VARCHAR(300) NOT NULL,

)

CREATE TABLE t_panier_pan
(
        pan_id INT PRIMARY KEY NOT NULL,
        pan_total FLOAT,
        pan_data DATE,
        --FK plus tard
)

CREATE TABLE t_historique_hst
(
    hst_id INT PRIMARY KEY NOT NULL,
)

CREATE TABLE t_plat_plt
(
        plt_id INT PRIMARY KEY NOT NULL,
        plt_nom VARCHAR(60)
        plt_description VARCHAR(500),
        plt_prix FLOAT,
        --FK plus tard
)

CREATE TABLE t_restaurant_rst
(
        rst_id INT PRIMARY KEY NOT NULL,
        rst_nom VARCHAR(60)
        rst_description VARCHAR(500),
        --FK plus tard
)

CREATE TABLE t_commentaire_com
(
        com_id INT PRIMARY KEY NOT NULL,
        com_texte VARCHAR(500),
        --FK plus tard
)

CREATE TABLE t_photo_pht
(
        pht_id INT PRIMARY KEY NOT NULL,
        ph_photo VARBINARY,
        --FK plus tard
)


--Table

CREATE TABLE t_panier_plat_tpp
(
    pan_id INT NOT NULL,
    plt_id INT NOT NULL

)

CREATE TABLE t_plat_historique_tph
(
    plt_id INT NOT NULL,
    hst_id INT NOT NULL
)