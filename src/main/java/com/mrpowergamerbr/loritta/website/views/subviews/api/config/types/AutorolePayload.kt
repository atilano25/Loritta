package com.mrpowergamerbr.loritta.website.views.subviews.api.config.types

import com.github.salomonbrys.kotson.array
import com.github.salomonbrys.kotson.bool
import com.github.salomonbrys.kotson.string
import com.google.gson.JsonObject
import com.mrpowergamerbr.loritta.dao.ServerConfig
import com.mrpowergamerbr.loritta.oauth2.TemmieDiscordAuth
import com.mrpowergamerbr.loritta.userdata.MongoServerConfig
import net.dv8tion.jda.core.entities.Guild

class AutorolePayload : ConfigPayloadType("autorole") {
	override fun process(payload: JsonObject, userIdentification: TemmieDiscordAuth.UserIdentification, serverConfig: ServerConfig, legacyServerConfig: MongoServerConfig, guild: Guild) {
		val autoroleConfig = legacyServerConfig.autoroleConfig
		autoroleConfig.isEnabled = payload["isEnabled"].bool
		autoroleConfig.roles = payload["roles"].array.map { it.string }.toMutableList()
	}
}