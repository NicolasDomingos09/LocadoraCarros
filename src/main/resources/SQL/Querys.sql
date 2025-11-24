-- Seleciona os dados do veículo, o nome e CPF do locatário, e a quantidade de dias que o carro está alugado para locações ativas no dia atual.
SELECT c.placa,
       c.marca,
       c.modelo,
       c.cor,
       c.ano,
       lt.nome                                   AS nome_locatario,
       lt.CPF                                    AS cpf_locatario,
       DATEDIFF(day, l.data_retirada, GETDATE()) AS dias_fora
FROM carro c
         JOIN
     locacao l ON c.placa = l.carro_placa
         JOIN
     locatario lt ON l.locatario_CPF = lt.CPF
WHERE l.data_retirada <= GETDATE()
  AND (l.data_devolucao IS NULL OR l.data_devolucao >= GETDATE());

-- Seleciona todos os dados de locação, veículo e locatário para um cliente específico, incluindo a descrição da categoria do veículo.
-- Basta substituir '?' pelo CPF do cliente desejado.
SELECT lt.CPF,
       lt.nome,
       lt.habilitacao,
       lt.nascimento,
       lt.logradouro,
       lt.CEP,
       lt.numero,
       lt.cidade,
       c.placa,
       c.marca,
       c.modelo,
       c.cor,
       c.ano,
       c.tipo_combustivel,
       c.quilometragem,
       c.tipo_cambio,
       cat.descricao AS descricao_categoria,
       l.data_retirada,
       l.dias_locacao,
       l.data_devolucao,
       l.valor_total,
       l.valor_extra
FROM locatario lt
         JOIN
     locacao l ON lt.CPF = l.locatario_CPF
         JOIN
     carro c ON l.carro_placa = c.placa
         JOIN
     categoria cat ON c.categoria_id = cat.id
WHERE lt.CPF = ?;

 -- Seleciona os dados do veículo e do reparo para os carros que estão atualmente em reparo.
 SELECT
     c.placa,
     c.marca,
     c.modelo,
     c.cor,
     c.ano,
     r.entrada,
     r.dias_reparo,
     r.diagnostico,
     r.valor_reparo
 FROM
     carro c
 JOIN
     reparo r ON c.placa = r.carro_placa
 WHERE
     '2025-11-29' BETWEEN r.entrada AND DATEADD(day, r.dias_reparo, r.entrada);

