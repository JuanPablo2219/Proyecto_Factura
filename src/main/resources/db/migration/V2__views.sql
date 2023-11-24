CREATE VIEW  invoice_view as
    select i.*, c.fullname
    from invoice i
    join client c on c.id = i.client_id;

