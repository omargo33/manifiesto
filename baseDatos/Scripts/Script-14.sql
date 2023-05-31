SELECT name
     , line
     , text
  FROM user_source
 WHERE lower (text)
  LIKE '%apex_web_service.%'
 ORDER BY name, line;