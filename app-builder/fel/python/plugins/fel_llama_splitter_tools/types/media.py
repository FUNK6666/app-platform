# -- encoding: utf-8 --
# Copyright (c) Huawei Technologies Co., Ltd. -. All rights reserved.
from .serializable import Serializable


class Media(Serializable):
    """
    Media.
    """
    mime: str
    data: str

    class Config:
        frozen = True
        smart_union = True
