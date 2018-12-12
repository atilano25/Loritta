package com.mrpowergamerbr.loritta.commands.vanilla.images

import com.mrpowergamerbr.loritta.Loritta
import com.mrpowergamerbr.loritta.commands.*
import com.mrpowergamerbr.loritta.utils.Constants
import com.mrpowergamerbr.loritta.utils.locale.BaseLocale
import java.awt.Image
import java.io.File
import java.util.*
import javax.imageio.ImageIO

class BolsoDrakeCommand : AbstractCommand("bolsodrake", category = CommandCategory.IMAGES) {
	override fun getDescription(locale: BaseLocale): String {
		return locale.format { commands.images.bolsoDrake.description }
	}

	override fun getExamples(): List<String> {
		return Arrays.asList("", "@Loritta @MrPowerGamerBR")
	}

	override fun getUsage(locale: BaseLocale): CommandArguments {
		return arguments {
			argument(ArgumentType.USER) {}
			argument(ArgumentType.USER) {}
		}
	}

	override fun needsToUploadFiles(): Boolean {
		return true
	}

	override suspend fun run(context: CommandContext,locale: BaseLocale) {
		val bi = ImageIO.read(File(Loritta.ASSETS + "bolsodrake.png")) // Primeiro iremos carregar o nosso template
		val graph = bi.graphics

		run {
			val avatarImg = context.getImageAt(0) ?: run { Constants.INVALID_IMAGE_REPLY.invoke(context); return; }
			val image = avatarImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH)
			graph.drawImage(image, 150, 0, null)
		}

		run {
			val avatarImg = context.getImageAt(1) ?: run { Constants.INVALID_IMAGE_REPLY.invoke(context); return; }
			val image = avatarImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH)
			graph.drawImage(image, 150, 150, null)
		}

		context.sendFile(bi, "bolsodrake.png", context.getAsMention(true))
	}
}