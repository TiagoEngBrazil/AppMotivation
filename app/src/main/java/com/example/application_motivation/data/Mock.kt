package com.example.application_motivation.data

import com.example.application_motivation.infra.MotivationConstants
import kotlin.random.Random

data class phrases(val description: String, val categoryID: Int, val lang: String)


class Mock {

    private val ALL = MotivationConstants.filter.all
    private val EMOTIONS = MotivationConstants.filter.emotions
    private val SUNNY = MotivationConstants.filter.sunny

    private val pt = MotivationConstants.Language.PORTUGUESE
    private val en = MotivationConstants.Language.English
    private val fr = MotivationConstants.Language.FRENCH

    private val mListPhrase = listOf<phrases>(
        phrases("Não sabendo que era impossível, foi lá e fez.", EMOTIONS, lang = pt),
        phrases(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            EMOTIONS,
            lang = pt
        ),
        phrases("Quando está mais escuro, vemos mais estrelas!", EMOTIONS, lang = pt),
        phrases(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            EMOTIONS,
            lang = pt
        ),
        phrases(
            "Não pare quando estiver cansado, pare quando tiver terminado.",
            EMOTIONS,
            lang = pt
        ),
        phrases(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            EMOTIONS,
            lang = pt
        ),
        phrases("A melhor maneira de prever o futuro é inventá-lo.", SUNNY, lang = pt),
        phrases("Você perde todas as chances que você não aproveita.", SUNNY, lang = pt),
        phrases("Fracasso é o condimento que dá sabor ao sucesso.", SUNNY, lang = pt),
        phrases("Enquanto não estivermos comprometidos, haverá hesitação!", SUNNY, lang =
        pt),
        phrases("Se você não sabe onde quer ir, qualquer caminho serve.", SUNNY, lang =
        pt),
        phrases("Se você acredita, faz toda a diferença.", SUNNY, lang = pt),
        phrases(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            SUNNY,
            lang = pt
        ),



        phrases("Not knowing it was impossible, he went there and did it.", EMOTIONS, lang
        = en),
        phrases("You are not defeated when you lose, you are defeated when you give up!",
            EMOTIONS, lang = en),
        phrases("When it's darker, we see more stars!", EMOTIONS, lang = en),
        phrases("Insanity is always doing the same thing and expecting a different " +
                "result.", EMOTIONS, lang = en),
        phrases("Don't stop when you're tired, stop when you're done.", EMOTIONS,
            lang = en),
        phrases("What can you do now that has the biggest impact on your success?"
            , EMOTIONS, lang = en),
        phrases("The best way to predict the future is to invent it.", SUNNY, lang = en),
        phrases("You lose every chance you don't take.", SUNNY, lang = en),
        phrases("Failure is the spice that flavors success.", SUNNY, lang = en),
        phrases("As long as we are not committed, there will be hesitation!", SUNNY, lang
        = en),
        phrases("If you don't know where you want to go, any way will do.", SUNNY, lang =
        en),
        phrases("If you believe, it makes all the difference.", SUNNY, lang = en),
        phrases("Risks must be taken, because the greatest danger is not risking" +
                " anything!", SUNNY, lang = en),



        phrases("Ne sachant pas que c'était impossible, il y est allé et l'a fait.",
            EMOTIONS, lang = fr),
        phrases("Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            EMOTIONS, lang = fr),
        phrases("Quand il fait plus sombre, on voit plus d'étoiles!", EMOTIONS, lang = fr),
        phrases( "La folie, c'est toujours faire la même chose et s'attendre à un " +
                "résultat différent.", EMOTIONS, lang = fr),
        phrases("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", EMOTIONS,
            lang = fr),
        phrases("Que pouvez-vous faire maintenant qui a le plus grand impact sur votre" +
                " succès?", EMOTIONS, lang = fr),
        phrases("La meilleure façon de prédire l'avenir est de l'inventer.", SUNNY, lang
        = fr),
        phrases("Vous perdez toutes les chances que vous ne prenez pas.", SUNNY, lang =
        fr),
        phrases("L'échec est l'épice qui parfume le succès.", SUNNY, lang = fr),
        phrases("Tant qu'on n'est pas engagé, il y aura des hésitations!", SUNNY,
            lang = fr),
        phrases("Si vous ne savez pas où vous voulez aller, n'importe quoi fera " +
                "l'affaire.", SUNNY, lang = fr),
        phrases("Si vous croyez, cela fait toute la différence.", SUNNY, lang = fr),
        phrases("Il faut prendre des risques, car le plus grand danger est de ne rien " +
                "risquer!", SUNNY, lang = fr)
    )

    fun getFrases(value: Int, lang: String): String {

        var filtered = mListPhrase.filter {
            (it.categoryID == value || value == ALL) && it.lang == lang
        }

        return filtered[Random.nextInt(filtered.size)].description
    }
}