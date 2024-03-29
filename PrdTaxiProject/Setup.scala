// Databricks notebook source
// MAGIC %md ###Section 1: Mount Azure Data Lake Store

// COMMAND ----------

val configs = Map(
  "dfs.adls.oauth2.access.token.provider.type" -> "ClientCredential",
  "dfs.adls.oauth2.client.id" -> "<client id>",
  "dfs.adls.oauth2.credential" -> "<client secret>",
  "dfs.adls.oauth2.refresh.url" -> "https://login.microsoftonline.com/<directory id>/oauth2/token"
)

dbutils.fs.mount(
  source = "adl://<data lake name>.azuredatalakestore.net",
  mountPoint = "/mnt/datalake",
  extraConfigs = configs
)

// COMMAND ----------

// MAGIC %md ###Section 2: Mount Azure Blob Storage

// COMMAND ----------

val configs = Map(
  "fs.azure.account.key.<storage name>.blob.core.windows.net" -> "<access key>"
)

dbutils.fs.mount(
  source = "wasbs://<container name>@<storage name>.blob.core.windows.net/",
  mountPoint = "/mnt/storage",
  extraConfigs = configs
)
