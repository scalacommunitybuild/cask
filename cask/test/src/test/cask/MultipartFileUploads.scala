package test.cask

import io.undertow.server.HttpServerExchange
import io.undertow.server.handlers.form.FormData

object MultipartFileUploads extends cask.MainRoutes{
  // curl -F "image=@build.sc" localhost:8080/upload
  @cask.post("/upload")
  def uploadFile(formData: FormData) = {
    val file = formData.getFirst("image")
    file.getFileName
  }

  initialize()
}

