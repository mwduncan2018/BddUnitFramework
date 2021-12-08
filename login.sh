echo 'Inside login.sh'

ABC="MY_LOGIN_USERNAME"

if [ $LOGIN_USERNAME == $ABC ]
then
  echo "SUCCESS"
else
  echo "FAILURE"
fi
