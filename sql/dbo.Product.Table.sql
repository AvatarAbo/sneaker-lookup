USE [SneakerLookup]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [int] IDENTITY(1,1) NOT NULL,
	[StoreId] [int] NOT NULL,
	[StoreName] [nvarchar](100) NOT NULL,
	[Website] [nvarchar](100) NULL,
	[Address] [nvarchar](256) NULL,
	[SneakerId] [int] NOT NULL,
	[ShoeSize] [nvarchar](10) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [decimal](9,2) NOT NULL,
	[ReleaseDate] [datetime2](7) NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)
)
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_SneakerId_Sneaker_SneakerId] FOREIGN KEY([SneakerId])
REFERENCES [dbo].[Sneaker] ([SneakerId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_SneakerId_Sneaker_SneakerId]
GO