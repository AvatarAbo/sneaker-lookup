USE [SneakerLookup]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Catalog](
	[CatalogId] [int] IDENTITY(1,1) NOT NULL,
	[SneakerId] [int] NOT NULL,
	[ShoeSize] [nvarchar](10) NOT NULL,
	[YearAcquired] [int] NOT NULL,
	[Condition] [nvarchar](4) NOT NULL,
	[MarketValue] [decimal](9,2) NOT NULL,
 CONSTRAINT [PK_Catalog] PRIMARY KEY CLUSTERED 
(
	[CatalogId] ASC
)
)
GO
ALTER TABLE [dbo].[Catalog]  WITH CHECK ADD  CONSTRAINT [FK_Catalog_SneakerId_Sneaker_SneakerId] FOREIGN KEY([SneakerId])
REFERENCES [dbo].[Sneaker] ([SneakerId])
GO
ALTER TABLE [dbo].[Catalog] CHECK CONSTRAINT [FK_Catalog_SneakerId_Sneaker_SneakerId]
GO