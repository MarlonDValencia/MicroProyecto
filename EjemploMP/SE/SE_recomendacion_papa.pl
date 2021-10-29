/*
---------------------------------------------------------------------------------
El siguiente sistema experto toma la altitud de un terreno (msnm),
su clima promedio (°C) y el rendimiento esperdo de producción (T/ha) 
para recomendarle al usuario que tipo de papa le dará el mejor rendimiento, 
tendrá mejor sostenibilidad y afectará menos negativamente al medio.
---------------------------------------------------------------------------------
*/
sugerir(X) :- write('Ingresa la altitud del terreno (msnm): '), read(AL),
    write('Ingresa el rendimiento esperado en toneladas por hectareas: '), read(R),
    write('Ingresa la temperatura media del ambiente del lugar: (°C) '),read(C),
    write('Ingresa las horas de exposición a luz:'),read(L),
    write('Ingresa el PH del terreno: '),read(PH),
    write('El nivel de agua a regar: (L/m^2) '),read(AG),
    verificar_agua(AG2,AG),
    verificar_luz(L2,L),
    verificar_ph(PH2,PH),
    /* write(''), */ 	
    recomendar(X,AL,R,C,AG2,L2,PH2).

/*Reglas de verificacion agua*/
verificar_agua(baja,AG):- AG<370.
verificar_agua(alta,AG):- AG>650.
verificar_agua(optima,AG):- AG=<650, AG>=370.

/*Reglas de verificacion luz */
verificar_luz(baja,L):-L<7.
verificar_luz(alta,L):-L>13.
verificar_luz(optima,L):-L=<13, L>=7.

/*Reglas de verificacion PH */
verificar_ph(acido,PH):-PH<6.5.
verificar_ph(basico,PH):-PH>7.5.
verificar_ph(neutro,PH):-PH=<7.5, PH>=6.5.

recomendar(poca_altitud,AL,_,_,_,_,_):- AL<1800,write('Los suelos a baja altura no son aptos para el cultivo de papa, busca un terreno más alto. '),!.
recomendar(mucha_altitud,AL,_,_,_,_,_):- AL>3500,write('Los suelos muy altos no son aptos para el cultivo de papa, busca un terreno más bajo. '),!.

recomendar(baja_temperatura,_,_,C,_,_,_):- C<10,write('A muy bajas temperaturas los cultivos de papas no son óptimos, los cultivos se pueden perder o la cosecha no es buena. '),!.
recomendar(alta_temperatura,_,_,C,_,_,_):- C>24,write('A muy altas temperaturas no se puede cultivar papa, pues la papa es propia de los climas templados. '),!.

recomendar(poca_luz,_,_,_,_,L2,_):-L2=baja,write('La poca luz no favorece el cecimiento de la planta, considera aumentar este número.'),!.
recomendar(mucha_luz,_,_,_,_,L2,_):-L2=alta,write('Tanta luz puede ser contraproducente para el desarrollo de la planta, intenta con valores más bajos.'),!.

recomendar(ph_acido,_,_,_,_,_,PH2):-PH2=acido,write('En un tierra con PH bajo el cultivo de papa no prospera, busca valores más neutros en la escala.'),!.
recomendar(ph_basico,_,_,_,_,_,PH2):-PH2=basico,write('En un tierra con PH alto el cultivo de papa no prospera, busca valores más neutros en la escala.'),!.

recomendar(mucha_agua,_,_,_,AG2,_,_):-AG2=alta,write('Con tanta agua el cultivo morirá o no será muy sostenible debido a el alto desperdicio de agua, intenta gastar menos en pro de la sostenibilidad y el exito del cultivo.'),!.
recomendar(poca_agua,_,_,_,AG2,_,_):-AG2=baja,write('Con poca agua el cultivo morirá pues seguramente se secará, intenta con valores más optimos.'),!.

recomendar(pastusa_suprema,A,R,C,_,_,_):-(A>=2000,A=<3500),(R>=15,R=<20),(C>=12,C=<18),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(diacol_capiro,A,R,C,_,_,_):-(A>=2300,A=<3200), (R>=25,R=<30),(C>=14,C=<17),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(parda_pastua,A,R,C,_,_,_):-(A>=2000,A=<3500), (R>=28,R=<33),(C>=10,C=<17),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(tocarreña,A,R,C,_,_,_):-(A>=2600,A=<3200), (R>=18,R=<23),(C>=15,C=<20),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(criolla,A,R,C,_,_,_):-(A>=1800,A=<3200), (R>=7,R=<12),(C>=10,C=<20),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(ica_unica,A,R,C,_,_,_):-(A>=2600,A=<3200), (R>=30,R=<45),(C>=13,C=<24),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(perla_negra,A,R,C,_,_,_):-(A>=2500,A=<2700), (R>=27,R=<37),(C>=10,C=<17),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(rubi,A,R,C,_,_,_):-(A>=2750,A=<3200), (R>=40,R=<47),(C>=10,C=<23),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
recomendar(ica_purace,A,R,C,_,_,_):-(A>=2200,A=<3000), (R>=30,R=<37),(C>=11,C=<18),write('El tipo de papa recomendado según las condiciones ingresadas es: ').
