USE [SneakerLookup]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sneaker](
	[SneakerId] [int] IDENTITY(1,1) NOT NULL,
	[Year] [int] NOT NULL,
	[Brand] [nvarchar](50) NOT NULL,
	[Model] [nvarchar](50) NOT NULL,
	[Colorway] [nvarchar](50) NOT NULL,
	[Type] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Sneaker] PRIMARY KEY CLUSTERED 
(
	[SneakerId] ASC
)
)
GO