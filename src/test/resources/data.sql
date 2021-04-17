insert into doctor (DOC_ID, DOC_NAME, LASTNAME, SPECIALIZATION, DOC_USR_ID)
values (1, 'Jan', 'Kaczmarczyk', 'Dentysta', null ),
(2, 'Igor', 'Kowalski', 'Chirurg', null),
(3, 'Zofia', 'Nowak', 'Pielęgniarka', null);
COMMIT;

insert into visit (VIS_ID, VIS_PAT_ID, VIS_DOC_ID, VIS_SER_ID, VIS_DATE)
values (1, null, 1, null, '2021-02-15 10:30:00'),
(2, null, 1, null, '2021-02-15 10:40:00'),
(3, null, 3, null, '2021-02-16 10:00:00');
commit;

