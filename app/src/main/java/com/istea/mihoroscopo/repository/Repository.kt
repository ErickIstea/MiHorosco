package com.istea.mihoroscopo.repository

import com.istea.mihoroscopo.R
import kotlinx.coroutines.delay

class Repository {

    suspend fun getSignos() : List<Signo> {
        delay(0)
        return listOf(
            aries,
            tauro,
            geminis,
            cancer,
            leo,
            virgo,
            libra,
            escorpio,
            sagitario,
            capricornio,
            acuario,
            piscis
        )
    }

    suspend fun getHoroscopo(signoId: String): Horoscopo {
        delay(2000)
        when(signoId){
            aries.signoId -> return prediccionAries
            tauro.signoId -> return prediccionTauro
            geminis.signoId -> return prediccionGeminis
            cancer.signoId -> return prediccionCancer
            leo.signoId -> return prediccionLeo
            virgo.signoId -> return prediccionVirgo
            libra.signoId -> return prediccionLibra
            escorpio.signoId -> return prediccionEscorpio
            sagitario.signoId -> return prediccionSagitario
            capricornio.signoId -> return prediccionCapricornio
            acuario.signoId -> return prediccionAcuario
            piscis.signoId -> return prediccionPiscis
        }
        return prediccionAries
    }




    val aries = Signo(
        signoId = "001",
        nombre = "Aries",
        descripcion = "Signo de fuego y el primero de la rueda zodiacal. ¡Inician el año astral! Los Aries llevan la palabra iniciativa escrita en la frente.",
        desde = "21/03",
        hasta = "19/04",
        iconId = R.drawable.s001,
        ilustrationId = R.drawable.i001
    )

    val tauro = Signo(
        signoId = "002",
        nombre = "Tauro",
        descripcion = "Este signo de tierra tiene un don natural para conquistar, gracias a su sensualidad innata, uno de los rasgos clave de la personalidad de los Tauro",
        desde = "20/04",
        hasta = "20/05",
        iconId = R.drawable.s002,
        ilustrationId = R.drawable.i002
    )

    val geminis = Signo(
        signoId = "003",
        nombre = "Geminis",
        descripcion = "Muy sociables y demasiado curiosos, aspecto negativo cuando se trata de establecer una relación ya que les cuesta mucho comprometerse",
        desde = "21/05",
        hasta = "20/06",
        iconId = R.drawable.s003,
        ilustrationId = R.drawable.i003
    )

    val cancer = Signo(
        signoId = "004",
        nombre = "Cancer",
        descripcion = "Se llevan el premio a los más sensibles del horóscopo. La palabra drama les pertenece y son capaces de generarlo en su cabeza con un motivo los más mínimo sensible",
        desde = "21/06",
        hasta = "22/07",
        iconId = R.drawable.s004,
        ilustrationId = R.drawable.i004
    )

    val leo = Signo(
        signoId = "005",
        nombre = "Leo",
        descripcion = "Estar bajo el signo de fuego del león significa tener luz propia, una extrema lealtad hacia los demás y una maravillosa facilidad para hacer sentir bien a las personas de su alrededor",
        desde = "23/07",
        hasta = "22/08",
        iconId = R.drawable.s005,
        ilustrationId = R.drawable.i005
    )

    val virgo = Signo(
        signoId = "006",
        nombre = "Virgo",
        descripcion = "El fin vital de cualquier Virgo, signo de tierra, es encontrar la perfección y la pureza en absolutamente todo lo que tiene alrededor.",
        desde = "23/08",
        hasta = "22/09",
        iconId = R.drawable.s006,
        ilustrationId = R.drawable.i006
    )

    val libra = Signo(
        signoId = "007",
        nombre = "Libra",
        descripcion = "No hay nada que le guste menos a un Libra que el desequilibrio, ya sea emocional o en las relaciones.",
        desde = "23/09",
        hasta = "22/10",
        iconId = R.drawable.s007,
        ilustrationId = R.drawable.i007
    )

    var escorpio = Signo(
        signoId = "008",
        nombre = "Escorpio",
        descripcion = "La personalidad de Escorpio tiene una parte muy buena y otra muy mala. Por un lado, son sensibles, muy comprensivos, luchan constantemente por lo que piensan que es justo.",
        desde = "23/10",
        hasta = "21/11",
        iconId = R.drawable.s008,
        ilustrationId = R.drawable.i008
    )

    val sagitario = Signo(
        signoId = "009",
        nombre = "Sagitario",
        descripcion = "Todos los actos de un Sagitario, signo de fuego, tienen como finalidad convertir las experiencias en aprendizaje. No obstante, esta inquietud y exceso de confianza en los demás.",
        desde = "22/11",
        hasta = "21/12",
        iconId = R.drawable.s009,
        ilustrationId = R.drawable.i009
    )

    val capricornio = Signo(
        signoId = "010",
        nombre = "Capricornio",
        descripcion = "Si los Capricornio tienen un rasgo de personalidad claro, es su ambición y disciplina. De hecho, es tal que es muy fácil que acaben perdiendo la perspectiva.",
        desde = "22/12",
        hasta = "19/01",
        iconId = R.drawable.s010,
        ilustrationId = R.drawable.i010
    )

    val acuario = Signo(
        signoId = "011",
        nombre = "Acuario",
        descripcion = "Lo más destacable de la personalidad de los Acuario es que nunca, nunca, nunca se dan por vencidos a la hora de luchar por su libertad.",
        desde = "20/01",
        hasta = "18/02",
        iconId = R.drawable.s011,
        ilustrationId = R.drawable.i011
    )

    val piscis = Signo(
        signoId = "012",
        nombre = "Piscis",
        descripcion = "Los Piscis tienen dos características de personalidad muy marcadas: su gusto por el drama y la imaginación. En la primera son unos cracks, de verdad.",
        desde = "19/02",
        hasta = "20/03",
        iconId = R.drawable.s012,
        ilustrationId = R.drawable.i012
    )

    val prediccionAries = Horoscopo(
        signo = aries,
        fecha = "2 de julio",
        amor = "Su enamorado se mostrará un tanto desapegado. Evite asustarse, ya que pronto le cambiará esa actitud frívola y la relación volverá a ser como antes.",
        riqueza = "No desaproveche el tiempo libre que le queda del día para ordenar los papeles y las cuentas pendientes. Evite que su administración sea un caos.",
        bienestar = "Sepa que en esta noche, le hará bien salir a disfrutar de un espectáculo o paseo en compañía de un amigo. Saque entradas y llámelo para invitarlo."
    )
    val prediccionTauro = Horoscopo(
        signo = tauro,
        fecha = "2 de julio",
        amor = "Evite buscar pelea, ya que no es el momento para replanteos en la relación de pareja. Sepa que la comunicación con su alma gemela podría volverse tensa.",
        riqueza = "Intente relajarse, ya que la presencia lunar lo favorecerá en los asuntos de negocios, finanzas y trabajo en esta jornada. Aprovecha las buenas energías.",
        bienestar = "Distiéndase y elija un hobby o actividad que le agrade demasiado para distraerse de la rutina pesada que esta últimamente teniendo en su vida."
    )

    val prediccionGeminis = Horoscopo(
        signo = geminis,
        fecha = "2 de julio",
        amor = "Teniendo a Júpiter en su signo esta energía le hará aumentar su interés por las conquistas amorosas. Aproveche esto para seducir a esa persona que le interesa.",
        riqueza = "Cuando se decida y consagre tiempo para poner en practica sus dotes profesionales, verá que surgirán nuevas fuentes de ingreso. Queda en usted la decisión.",
        bienestar = "Sea conciente y acepte que necesita si o si alimentarse sanamente."
    )

    val prediccionCancer = Horoscopo(
        signo = cancer,
        fecha = "2 de julio",
        amor = "Si ha comenzado una relación amorosa, procure de ser cuidadoso y dejar la obsesión de lado. Si no cambia de actitud, esta nueva persona se alejara rápido.",
        riqueza = "Ponga toda su energía, ya que ese asunto financiero le requerirá de toda su atención en esta jornada. Esté atento, por si acaso debe realizar algún movimiento.",
        bienestar = " Por una vez en su vida, sea constante y no busque más excusas para poder cumplir en su totalidad con ese tratamiento que comenzó para adelgazar."
    )

    val prediccionLeo = Horoscopo(
        signo = leo,
        fecha = "2 de julio",
        amor = "Empiece a ser más coherente cuando deba seleccionar un amor. Comprenda que muchas veces la apariencia de una persona no es la pura realidad.",
        riqueza = "Sepa que esa tendencia a gastar más de la cuenta le podría traer problemas económicos a corto plazo. Tenga cuidado con las compras que hace.",
        bienestar = "Evite negarse y de comienzo hoy mismo a una dieta equilibrada en frutas y verduras. En muy poco tiempo, se empezará a sentir más ágil y saludable."
    )

    val prediccionVirgo = Horoscopo(
        signo = virgo,
        fecha = "2 de julio",
        amor = "Diga lo que siente y no se arrepienta de sus actos. Sepa que la persona que tiene a su lado muchas veces quiere escuchar cuanto la quiere y que ocupa en su vida.",
        riqueza = "No pierda más el tiempo y asesórese por un profesional, de esta forma podrá despejar muchas de las dudas que tiene sobre ese inconveniente financiero.",
        bienestar = "Junto a su pareja, le será muy conveniente empezar a planificar las vacaciones de verano. Busque y reserve con tiempo el lugar soñado por ambos."
    )

    val prediccionLibra = Horoscopo(
        signo = libra,
        fecha = "2 de julio",
        amor = "Se acerca una etapa de reconciliaciones y reencuentros amorosos. Sepa que necesitará dejarse llevar por lo que siente y disfrutar del momento.",
        riqueza = "Después de tantos problemas, podrá superar todas las barreras laborales que se intercedan frente a usted para alcanzar el crecimiento profesional.",
        bienestar = "Para el próximo fin de semana, planifique algún tipo de actividad al aire libre que le permita distraerse y alejarse de su rutina junto a su familia."
    )

    val prediccionEscorpio = Horoscopo(
        signo = escorpio,
        fecha = "2 de julio",
        amor = "Prepárese, ya que en esta jornada estará muy irritable y de mal humor. Procure no discutir con su alma gemela por culpa de su estado. Tome distancia.",
        riqueza = "Durante esta jornada, estará muy ocupado en el manejo financiero de sus cuentas personales. Evite angustiarse y trate de equilibrar los gastos.",
        bienestar = "No se preocupe más, ya que gracias a su imaginación creativa podrá llegar a combatir la rutina y el aburrimiento que esta teniendo hace días."
    )

    val prediccionSagitario = Horoscopo(
        signo = sagitario,
        fecha = "2 de julio",
        amor = "Aproveche que el amor esta cerca y emplee todas sus herramientas de seducción. Salga esta noche y podrá conquistar a la persona que usted se proponga.",
        riqueza = "Despreocúpese, ya que en poco tiempo todos sus deseos y ambiciones lógicas se concretarán sin problemas dentro de su mundo laboral. Este preparado.",
        bienestar = " Aprenda que la vida no es solo trabajo. Permítase tener un lugar para el placer y la alegría junto a todos sus seres queridos. Disfrute de los buenos momentos."
    )

    val prediccionCapricornio = Horoscopo(
        signo = capricornio,
        fecha = "2 de julio",
        amor = "Momento para que acepte que la inseguridad es su peor enemiga. Aprenda a controlar los celos, de lo contrario, su pareja no estará dispuesta a tolerarlo.",
        riqueza = "Entienda que la clave para cuidar sus recursos económicos, será no generando deudas innecesarias. Momento para cuidar los gastos que realiza.",
        bienestar = "Sepa que su cuerpo le pedirá un descanso, acceda a su demanda y tómese unos momentos durante la jornada para relajarse de la manera que usted quiera."
    )

    val prediccionAcuario = Horoscopo(
        signo = acuario,
        fecha = "2 de julio",
        amor = " Comience a valorar un poco más a su alma gemela. Momento para que analice sus sentimientos y abandone los arrebatos negativos que últimamente esta teniendo.",
        riqueza = "En este jornada, existen amplias probabilidades de ganar en los juegos de azar. Aunque no este acostumbrado al juego, déjese guiar por su intuición.",
        bienestar = " Modere la ingesta de las carnes y los dulces. No retrase por más tiempo un cambio en su alimentación, sino puede solo busque ayuda en un nutricionista."
    )

    val prediccionPiscis = Horoscopo(
        signo = piscis,
        fecha = "2 de julio",
        amor = "Deje de estar tan pendiente si la relación que comenzó hace poco con esa persona es para toda la vida. Entienda que debe dejar fluir el amor.",
        riqueza = "Momento para ajustarse a su presupuesto. Intente ser más riguroso en el manejo de sus finanzas. Evite realizar gastos inútiles para su economía.",
        bienestar = "Cuando se relacione con las personas, permítase ser más original en la vida. Intente abandonar esa formalidad que demuestra de manera natural."
    )
}