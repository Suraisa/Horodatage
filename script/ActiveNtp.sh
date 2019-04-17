ntptime | grep -m2 maximum | tail -n1 >>"$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"/../data/ntpTime
date +%s%N >> "$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"/../data/ntpTime
timedatectl set-ntp true
date +%s%N >> "$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"/../data/ntpTime
echo -e \ >> "$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"/../data/ntpTime
timedatectl set-ntp false