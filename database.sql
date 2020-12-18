CREATE TABLE `t_client_cli`
(
    cli_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT ,
    cli_nom VARCHAR(60) NOT NULL,
    cli_prenom VARCHAR(60) NOT NULL,
    cli_numero_tel VARCHAR(10) NOT NULL,
    cli_email VARCHAR(60) NOT NULL,
    cli_adresse VARCHAR(300) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `t_panier_pan`
(
        pan_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        pan_total FLOAT,
        pan_data DATE,
        cli_id INT
);

CREATE TABLE `t_historique_hst`
(
    hst_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cli_id INT
);

CREATE TABLE `t_plat_plt`
(
        plt_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        plt_nom VARCHAR(60),
        plt_description VARCHAR(500),
        plt_prix FLOAT,
        rst_id INT
);

CREATE TABLE `t_restaurant_rst`
(
        rst_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,  
        rst_nom VARCHAR(60),
        rst_description VARCHAR(500)
);

CREATE TABLE `t_commentaire_com`
(
        com_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        com_texte VARCHAR(500),
        cli_id INT,
        plt_id INT
);

CREATE TABLE `t_photo_pht`
(
        pht_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
        pht_photo VARBINARY(200),
        com_id INT
);

CREATE TABLE `t_panier_plat_tpp`
(
    pan_id INT NOT NULL,
    plt_id INT NOT NULL

);

CREATE TABLE `t_plat_historique_tph`
(
    plt_id INT NOT NULL,
    hst_id INT NOT NULL
);

ALTER TABLE `t_panier_pan`
    ADD CONSTRAINT `fk_panier_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);


ALTER TABLE `t_historique_hst`
    ADD CONSTRAINT `fk_historique_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);

ALTER TABLE `t_commentaire_com`
    ADD CONSTRAINT `fk_commentaire_client` FOREIGN KEY (`cli_id`) REFERENCES `t_client_cli` (`cli_id`);


ALTER TABLE `t_plat_plt`
    ADD CONSTRAINT `fk_plat_restaurant` FOREIGN KEY (`rst_id`) REFERENCES `t_restaurant_rst` (`rst_id`);
    

ALTER TABLE `t_commentaire_com`
    ADD CONSTRAINT `fk_commentaire_plat` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`);


ALTER TABLE `t_photo_pht`
    ADD CONSTRAINT `fk_photo_commentaire` FOREIGN KEY (`com_id`) REFERENCES `t_commentaire_com` (`com_id`);


ALTER TABLE `t_panier_plat_tpp`
    ADD CONSTRAINT `fk_panier_tpp` FOREIGN KEY (`pan_id`) REFERENCES `t_panier_pan` (`pan_id`);
    

ALTER TABLE `t_panier_plat_tpp`
    ADD CONSTRAINT `fk_plat_tpp` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`);

ALTER TABLE `t_plat_historique_tph`
    ADD CONSTRAINT `fk_plat_tph` FOREIGN KEY (`plt_id`) REFERENCES `t_plat_plt` (`plt_id`);

ALTER TABLE `t_plat_historique_tph`
    ADD CONSTRAINT `fk_historique_tph` FOREIGN KEY (`hst_id`) REFERENCES `t_historique_hst` (`hst_id`);
    


    