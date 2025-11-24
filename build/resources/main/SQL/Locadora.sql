CREATE DATABASE Locadora;
GO

USE Locadora;
GO

CREATE OR ALTER FUNCTION listarCarrosDisponiveis(@categoria_id_param INT = NULL)
    RETURNS @carrosDisponiveis TABLE
                               (
                                   placa            VARCHAR(9),
                                   marca            VARCHAR(150),
                                   modelo           VARCHAR(150),
                                   cor              VARCHAR(150),
                                   ano              INT,
                                   tipo_combustivel VARCHAR(9),
                                   quilometragem    INT,
                                   tipo_cambio      VARCHAR(150),
                                   categoria_id     INT,
                                   imagem_path      VARCHAR(MAX)
                               )
AS
BEGIN
    DECLARE @placa VARCHAR(9),
        @marca VARCHAR(150),
        @modelo VARCHAR(150),
        @cor VARCHAR(150),
        @ano INT,
        @tipo_combustivel VARCHAR(9),
        @quilometragem INT,
        @tipo_cambio VARCHAR(150),
        @categoria_id INT,
        @imagem_path VARCHAR(MAX);

    DECLARE cursor_carros CURSOR FOR
        SELECT placa,
               marca,
               modelo,
               cor,
               ano,
               tipo_combustivel,
               quilometragem,
               tipo_cambio,
               categoria_id,
               imagem_path
        FROM carro
        WHERE (@categoria_id_param IS NULL OR categoria_id = @categoria_id_param);

    OPEN cursor_carros;

    FETCH NEXT FROM cursor_carros INTO @placa, @marca, @modelo, @cor, @ano, @tipo_combustivel, @quilometragem, @tipo_cambio, @categoria_id, @imagem_path;

    WHILE @@FETCH_STATUS = 0
        BEGIN
            DECLARE @locado INT;
            DECLARE @emReparo INT;

            SELECT @locado = COUNT(*)
            FROM locacao
            WHERE carro_placa = @placa
              AND (
                    -- locação em andamento com data_devolucao NULL
                    (data_devolucao IS NULL AND data_retirada <= GETDATE())
                    -- ou locação com intervalo definido que engloba a data atual
                    OR (GETDATE() BETWEEN data_retirada AND data_devolucao)
                  );

            SELECT @emReparo = COUNT(*)
            FROM reparo
            WHERE carro_placa = @placa
              AND GETDATE() BETWEEN entrada AND DATEADD(day, dias_reparo, entrada);

            IF @locado = 0 AND @emReparo = 0
                BEGIN
                    INSERT INTO @carrosDisponiveis (placa, marca, modelo, cor, ano, tipo_combustivel, quilometragem, tipo_cambio,
                                                    categoria_id, imagem_path)
                    VALUES (@placa, @marca, @modelo, @cor, @ano, @tipo_combustivel, @quilometragem, @tipo_cambio, @categoria_id,
                            @imagem_path);
                END

            FETCH NEXT FROM cursor_carros INTO @placa, @marca, @modelo, @cor, @ano, @tipo_combustivel, @quilometragem, @tipo_cambio, @categoria_id, @imagem_path;
        END

    CLOSE cursor_carros;
    DEALLOCATE cursor_carros;

    RETURN;
END

SELECT * FROM listarCarrosDisponiveis(6);


